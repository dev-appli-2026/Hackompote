DROP SCHEMA IF EXISTS hackompote CASCADE;
CREATE SCHEMA hackompote;

SET search_path TO hackompote;

-- ==========================================
-- 1. TABLES PRINCIPALES
-- ==========================================

CREATE TABLE Utilisateur (
    id_utilisateur  SERIAL PRIMARY KEY,
    nom             VARCHAR(255) NOT NULL,
    prenom          VARCHAR(255) NOT NULL,
    pseudo          VARCHAR(255) NOT NULL,
    date_naissance  DATE NOT NULL,
    adresse_mail    VARCHAR(255) NOT NULL UNIQUE,
    mot_de_passe    VARCHAR(255) NOT NULL,
    role            VARCHAR(50) NOT NULL CHECK (role IN ('Participant', 'Mentor', 'Jury', 'Admin')),
    lien_cv         VARCHAR(255),
    competences_cles    TEXT,
    statut_recherche    BOOLEAN DEFAULT TRUE
);

CREATE TABLE Evenement (
    id_evenement        SERIAL PRIMARY KEY,
    nom                 VARCHAR(255) NOT NULL,
    date_debut          TIMESTAMP NOT NULL,
    date_fin            TIMESTAMP NOT NULL,
    duree_heures        INT NOT NULL,
    nb_max_par_equipe   INT NOT NULL,
    statut_event        VARCHAR(50) DEFAULT 'Brouillon' CHECK (statut_event IN ('Brouillon', 'Publié', 'En cours', 'Clôturé')),
    localisation_geo    VARCHAR(255),
    lien_billetterie    VARCHAR(255)
);

CREATE TABLE Sujet (
    id_sujet                SERIAL PRIMARY KEY,
    titre                   VARCHAR(255) NOT NULL,
    description_detaillee   TEXT NOT NULL,
    technologies_requises   VARCHAR(255),

    id_evenement    INT NOT NULL,
    id_proposant    INT,
    CONSTRAINT fk_sujet_evenement FOREIGN KEY (id_evenement) REFERENCES Evenement(id_evenement),
    CONSTRAINT fk_sujet_proposant FOREIGN KEY (id_proposant) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Equipe (
    id_equipe   SERIAL PRIMARY KEY,
    nom_equipe  VARCHAR(255) NOT NULL UNIQUE,
    lien_livrable VARCHAR(255),

    id_mentor   INT,
    id_sujet    INT,
    CONSTRAINT fk_equipe_mentor FOREIGN KEY (id_mentor) REFERENCES Utilisateur(id_utilisateur),
    CONSTRAINT fk_equipe_sujet  FOREIGN KEY (id_sujet)  REFERENCES Sujet(id_sujet)
);

-- ==========================================
-- 2. TABLES DE LIAISON ET D'ÉVALUATION
-- ==========================================

CREATE TABLE Score (
    id_score            SERIAL PRIMARY KEY,
    valeur_score        DECIMAL(5,2) NOT NULL,
    critere_evaluation  VARCHAR(100) NOT NULL,
    commentaire         TEXT,

    id_jury     INT NOT NULL,
    id_sujet    INT NOT NULL,
    id_equipe   INT NOT NULL,
    CONSTRAINT fk_score_jury   FOREIGN KEY (id_jury)   REFERENCES Utilisateur(id_utilisateur),
    CONSTRAINT fk_score_sujet  FOREIGN KEY (id_sujet)  REFERENCES Sujet(id_sujet),
    CONSTRAINT fk_score_equipe FOREIGN KEY (id_equipe) REFERENCES Equipe(id_equipe)
);

CREATE TABLE Inscription_Evenement (
    id_evenement    INT,
    id_utilisateur  INT,
    date_inscription TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_evenement, id_utilisateur),
    CONSTRAINT fk_insc_evenement    FOREIGN KEY (id_evenement)   REFERENCES Evenement(id_evenement),
    CONSTRAINT fk_insc_utilisateur  FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Composer_Equipe (
    id_equipe       INT,
    id_utilisateur  INT,
    PRIMARY KEY (id_equipe, id_utilisateur),
    CONSTRAINT fk_compo_equipe      FOREIGN KEY (id_equipe)      REFERENCES Equipe(id_equipe),
    CONSTRAINT fk_compo_utilisateur FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

-- ==========================================
-- 3. NOUVELLES TABLES
-- ==========================================

CREATE TABLE Sponsor (
    id_sponsor          SERIAL PRIMARY KEY,
    nom_entreprise      VARCHAR(255) NOT NULL,
    niveau_partenariat  VARCHAR(50) CHECK (niveau_partenariat IN ('Gold', 'Silver', 'Bronze')),

    id_evenement INT NOT NULL,
    CONSTRAINT fk_sponsor_evenement FOREIGN KEY (id_evenement) REFERENCES Evenement(id_evenement) ON DELETE CASCADE
);

CREATE TABLE Badge (
    id_badge    SERIAL PRIMARY KEY,
    nom_badge   VARCHAR(100) NOT NULL,
    icone_url   VARCHAR(255)
);

CREATE TABLE Obtenir_Badge (
    id_utilisateur  INT,
    id_badge        INT,
    date_obtention  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_utilisateur, id_badge),
    CONSTRAINT fk_badge_utilisateur FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur) ON DELETE CASCADE,
    CONSTRAINT fk_badge_badge       FOREIGN KEY (id_badge)       REFERENCES Badge(id_badge) ON DELETE CASCADE
);

CREATE TABLE Rdv_Mentor (
    id_rdv      SERIAL PRIMARY KEY,
    date_heure  TIMESTAMP NOT NULL,
    statut_rdv  VARCHAR(50) DEFAULT 'Planifié',

    id_equipe   INT NOT NULL,
    id_mentor   INT NOT NULL,
    CONSTRAINT fk_rdv_equipe  FOREIGN KEY (id_equipe) REFERENCES Equipe(id_equipe),
    CONSTRAINT fk_rdv_mentor  FOREIGN KEY (id_mentor) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Journal_Bord (
    id_journal  SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    date_entree TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    id_equipe INT NOT NULL,
    CONSTRAINT fk_journal_equipe FOREIGN KEY (id_equipe) REFERENCES Equipe(id_equipe) ON DELETE CASCADE
);

CREATE TABLE Prix (
    id_prix     SERIAL PRIMARY KEY,
    nom_prix    VARCHAR(255) NOT NULL,
    recompense  VARCHAR(255),

    id_evenement    INT NOT NULL,
    id_equipe       INT,
    CONSTRAINT fk_prix_evenement FOREIGN KEY (id_evenement) REFERENCES Evenement(id_evenement) ON DELETE CASCADE,
    CONSTRAINT fk_prix_equipe    FOREIGN KEY (id_equipe)    REFERENCES Equipe(id_equipe)
);

CREATE TABLE Favori_Recrutement (
    id_favori       SERIAL PRIMARY KEY,
    note_interne    TEXT,

    id_recruteur    INT NOT NULL,
    id_participant  INT NOT NULL,
    CONSTRAINT fk_favori_recruteur   FOREIGN KEY (id_recruteur)   REFERENCES Utilisateur(id_utilisateur),
    CONSTRAINT fk_favori_participant FOREIGN KEY (id_participant)  REFERENCES Utilisateur(id_utilisateur)
);