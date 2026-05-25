TRUNCATE TABLE hackompote.evenement RESTART IDENTITY CASCADE;

INSERT INTO hackompote.evenement
(nom, date_debut, date_fin, duree_heures, nb_max_par_equipe, statut_event, localisation_geo, lien_billetterie)
VALUES
      ('Tournoi E-sport Étudiant', '2026-06-10 14:00:00', '2026-06-10 20:00:00', 6, 5, 'Publié', 'Paris, France', 'https://exemple.com/billetterie/esport'),
      ('Hackathon IA Campus', '2026-06-15 09:00:00', '2026-06-16 18:00:00', 33, 4, 'Publié', 'Lyon, France', 'https://exemple.com/billetterie/hackathon-ia'),
      ('Soirée Networking Dev', '2026-06-20 19:00:00', '2026-06-20 23:00:00', 4, 6, 'En cours', 'Lille, France', 'https://exemple.com/billetterie/networking-dev'),
      ('Challenge Robotique', '2026-07-02 10:00:00', '2026-07-02 17:00:00', 7, 3, 'Publié', 'Toulouse, France', 'https://exemple.com/billetterie/robotique'),
      ('Festival Gaming & Tech', '2026-07-10 12:00:00', '2026-07-12 22:00:00', 58, 8, 'Publié', 'Marseille, France', 'https://exemple.com/billetterie/gaming-tech'),
      ('Compétition de Programmation', '2026-07-18 08:30:00', '2026-07-18 18:30:00', 10, 4, 'Brouillon', 'Grenoble, France', 'https://exemple.com/billetterie/prog'),
      ('Salon Innovation Numérique', '2026-08-01 09:00:00', '2026-08-01 19:00:00', 10, 10, 'Publié', 'Bordeaux, France', 'https://exemple.com/billetterie/innovation'),
      ('Atelier UX/UI Design', '2026-08-08 13:00:00', '2026-08-08 17:00:00', 4, 12, 'En cours', 'Nantes, France', 'https://exemple.com/billetterie/uxui'),
      ('Marathon Code Open Source', '2026-08-20 09:00:00', '2026-08-21 21:00:00', 36, 5, 'Publié', 'Paris, France', 'https://exemple.com/billetterie/open-source'),
      ('Conférence Startups & IA', '2026-09-05 10:00:00', '2026-09-05 16:00:00', 6, 7, 'Clôturé', 'Nice, France', 'https://exemple.com/billetterie/startups-ia');