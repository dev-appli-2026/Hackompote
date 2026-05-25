-- Mot de passe en clair pour tous les utilisateurs de test : Azerty123!
INSERT INTO hackompote.utilisateur
(nom, prenom, pseudo, date_naissance, adresse_mail, mot_de_passe, role, lien_cv, competences_cles, statut_recherche)
VALUES
    ('Martin', 'Lucas', 'LukaDev', '2002-04-15', 'lucas.martin@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Participant', 'https://cv.fake/lucas', 'Java, Spring Boot, SQL', TRUE),
    ('Bernard', 'Emma', 'EmmaCode', '2001-09-21', 'emma.bernard@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Participant', 'https://cv.fake/emma', 'HTML, CSS, JavaScript', TRUE),
    ('Dubois', 'Hugo', 'HugoCraft', '1999-12-10', 'hugo.dubois@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Mentor', 'https://cv.fake/hugo', 'Architecture logicielle, Java', FALSE),
    ('Petit', 'Chloe', 'ChloeUX', '2000-06-08', 'chloe.petit@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Mentor', 'https://cv.fake/chloe', 'UX/UI, Figma, Frontend', TRUE),
    ('Robert', 'Nathan', 'NateAlgo', '1998-11-03', 'nathan.robert@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Jury', 'https://cv.fake/nathan', 'Algorithmes, Python, Data', FALSE),
    ('Richard', 'Sarah', 'SarahTech', '1997-02-14', 'sarah.richard@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Jury', 'https://cv.fake/sarah', 'Cloud, DevOps, Sécurité', FALSE),
    ('Durand', 'Leo', 'LeoBuild', '2003-01-30', 'leo.durand@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Participant', NULL, 'Bukkit, Paper, YAML', TRUE),
    ('Moreau', 'Ines', 'InesWeb', '2002-07-19', 'ines.moreau@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Participant', NULL, 'PHP, MySQL, Bootstrap', TRUE),
    ('Simon', 'Tom', 'TomSys', '2001-03-11', 'tom.simon@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Participant', 'https://cv.fake/tom', 'Linux, Bash, Réseaux', TRUE),
    ('Laurent', 'Jade', 'JadeAI', '2000-08-24', 'jade.laurent@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Participant', 'https://cv.fake/jade', 'IA, Machine Learning, Python', TRUE),
    ('Michel', 'Noa', 'NoaAdmin', '1996-05-17', 'noa.michel@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Admin', NULL, 'Administration, PostgreSQL', FALSE),
    ('Garcia', 'Lina', 'LinaData', '2002-10-05', 'lina.garcia@mail.com', '$2a$12$GhvMmNVjRW29ulnudl.LbuAnUtN/LRfe1JsBm1Xu6LE3059z5Tr8m', 'Participant', 'https://cv.fake/lina', 'SQL, Power BI, Analyse', TRUE);