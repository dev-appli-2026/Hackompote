DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA public;

-- ==========================================
-- 1. TABLES PRINCIPALES (Fusionnées avec les ajouts)
-- ==========================================

CREATE TABLE Utilisateur (
   id_utilisateur INT AUTO_INCREMENT,
   nom VARCHAR(255) NOT NULL,
   prenom VARCHAR(255) NOT NULL,
   date_naissance DATE NOT NULL,
   adresse_mail VARCHAR(255) NOT NULL,
   mot_de_passe VARCHAR(255) NOT NULL,
   role VARCHAR(50) NOT NULL CHECK(role IN('Participant', 'Mentor', 'Jury', 'Admin')),
   lien_cv VARCHAR(255),
   competences_cles TEXT,
   statut_recherche BOOLEAN DEFAULT TRUE,
   PRIMARY KEY(id_utilisateur),
   UNIQUE(adresse_mail)
);

CREATE TABLE Evenement (
   id_evenement INT AUTO_INCREMENT,
   nom VARCHAR(255) NOT NULL,
   date_debut DATETIME NOT NULL,
   date_fin DATETIME NOT NULL,
   duree_heures INT NOT NULL,
   nb_max_par_equipe INT NOT NULL,
   statut_event VARCHAR(50) DEFAULT 'Brouillon' CHECK (statut_event IN ('Brouillon', 'Publié', 'En cours', 'Clôturé')),
   localisation_geo VARCHAR(255),
   lien_billetterie VARCHAR(255),
   PRIMARY KEY(id_evenement)
);

CREATE TABLE Sujet (
   id_sujet INT AUTO_INCREMENT,
   titre VARCHAR(255) NOT NULL,
   description_detaillee TEXT NOT NULL,
   technologies_requises VARCHAR(255),
   id_evenement INT NOT NULL,
   id_proposant INT,
   PRIMARY KEY(id_sujet),
   FOREIGN KEY(id_evenement) REFERENCES Evenement(id_evenement),
   CONSTRAINT Proposer_Idee FOREIGN KEY(id_proposant) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Equipe (
   id_equipe INT AUTO_INCREMENT,
   nom_equipe VARCHAR(255) NOT NULL,
   lien_livrable VARCHAR(255),
   id_mentor INT,
   id_sujet INT,
   PRIMARY KEY(id_equipe),
   UNIQUE(nom_equipe),
   FOREIGN KEY(id_mentor) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_sujet) REFERENCES Sujet(id_sujet)
);

-- ==========================================
-- 2. TABLES DE LIAISON ET D'ÉVALUATION INITIALES
-- ==========================================

CREATE TABLE Score (
   id_score INT AUTO_INCREMENT,
   valeur_score DECIMAL(5,2) NOT NULL,
   critere_evaluation VARCHAR(100) NOT NULL,
   commentaire TEXT,
   id_jury INT NOT NULL,
   id_sujet INT NOT NULL,
   id_equipe INT NOT NULL,
   PRIMARY KEY(id_score),
   FOREIGN KEY(id_jury) REFERENCES Utilisateur(id_utilisateur),
   FOREIGN KEY(id_sujet) REFERENCES Sujet(id_sujet),
   FOREIGN KEY(id_equipe) REFERENCES Equipe(id_equipe)
);

CREATE TABLE Inscription_Evenement (
   id_evenement INT,
   id_utilisateur INT,
   date_inscription DATETIME DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY(id_evenement, id_utilisateur),
   FOREIGN KEY(id_evenement) REFERENCES Evenement(id_evenement),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Composer_Equipe (
   id_equipe INT,
   id_utilisateur INT,
   PRIMARY KEY(id_equipe, id_utilisateur),
   FOREIGN KEY(id_equipe) REFERENCES Equipe(id_equipe),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

-- ==========================================
-- 3. NOUVELLES TABLES (Cycle de vie complet)
-- ==========================================

-- Phase 1 : Sponsors
CREATE TABLE Sponsor (
    id_sponsor INT PRIMARY KEY AUTO_INCREMENT,
    nom_entreprise VARCHAR(255) NOT NULL,
    niveau_partenariat VARCHAR(50) CHECK (niveau_partenariat IN ('Gold', 'Silver', 'Bronze')),
    id_evenement INT NOT NULL,
    CONSTRAINT Financer FOREIGN KEY (id_evenement) REFERENCES Evenement(id_evenement) ON DELETE CASCADE
);

-- Phase 2 : Badges & Gamification
CREATE TABLE Badge (
    id_badge INT PRIMARY KEY AUTO_INCREMENT,
    nom_badge VARCHAR(100) NOT NULL,
    icone_url VARCHAR(255)
);

CREATE TABLE Obtenir_Badge (
    id_utilisateur INT,
    id_badge INT,
    date_obtention DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_utilisateur, id_badge),
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur) ON DELETE CASCADE,
    FOREIGN KEY (id_badge) REFERENCES Badge(id_badge) ON DELETE CASCADE
);

-- Phase 3 : Mentorat et Journal de Bord
CREATE TABLE Rdv_Mentor (
    id_rdv INT PRIMARY KEY AUTO_INCREMENT,
    date_heure DATETIME NOT NULL,
    statut_rdv VARCHAR(50) DEFAULT 'Planifié',
    id_equipe INT NOT NULL,
    id_mentor INT NOT NULL,
    FOREIGN KEY (id_equipe) REFERENCES Equipe(id_equipe),
    FOREIGN KEY (id_mentor) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Journal_Bord (
    id_journal INT PRIMARY KEY AUTO_INCREMENT,
    description TEXT NOT NULL,
    date_entree DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_equipe INT NOT NULL,
    FOREIGN KEY (id_equipe) REFERENCES Equipe(id_equipe) ON DELETE CASCADE
);

-- Phase 5 : Remise des Prix et Recrutement
CREATE TABLE Prix (
    id_prix INT PRIMARY KEY AUTO_INCREMENT,
    nom_prix VARCHAR(255) NOT NULL,
    recompense VARCHAR(255),
    id_evenement INT NOT NULL,
    id_equipe INT,
    FOREIGN KEY (id_evenement) REFERENCES Evenement(id_evenement) ON DELETE CASCADE,
    FOREIGN KEY (id_equipe) REFERENCES Equipe(id_equipe)
);

CREATE TABLE Favori_Recrutement (
    id_favori INT PRIMARY KEY AUTO_INCREMENT,
    note_interne TEXT,
    id_recruteur INT NOT NULL,
    id_participant INT NOT NULL,
    FOREIGN KEY (id_recruteur) REFERENCES Utilisateur(id_utilisateur),
    FOREIGN KEY (id_participant) REFERENCES Utilisateur(id_utilisateur)
);