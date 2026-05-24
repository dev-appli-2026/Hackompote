TRUNCATE TABLE hackompote.utilisateur RESTART IDENTITY CASCADE;

-- Mot de passe en clair pour tous les utilisateurs de test : test123
INSERT INTO hackompote.utilisateur
(nom, prenom, pseudo, date_naissance, adresse_mail, mot_de_passe, role, lien_cv, competences_cles, statut_recherche)
VALUES
    ('Martin', 'Lucas', 'lmartin', '2002-04-18', 'lucas.martin@mail.com', '$2a$10$7EqJtq98hPqEX7fNZaFWoOHiA4P0N1GjYx6G6D5sWZXoqBYwygJyW', 'Participant', 'https://cv.example.com/lmartin', 'Java, Spring Boot, SQL, Git', TRUE),
    ('Bernard', 'Sarah', 'sbernard', '2001-11-03', 'sarah.bernard@mail.com', '$2a$10$e0NRaKWXAcM6M2M8g0w5O.8sV6PBs6vJ6D9h8KQwJw0zQ0mY9i9sK', 'Mentor', 'https://cv.example.com/sbernard', 'HTML, CSS, JavaScript, Bootstrap', TRUE),
    ('Petit', 'Nina', 'npetit', '2003-06-27', 'nina.petit@mail.com', '$2a$10$wH6Fz0M7D3YdS0kBArlYz.E7xW8z2xG9m2R0QfM2Xxk9n2A5mP7rS', 'Participant', NULL, 'Python, Bash, Linux, Algorithmique', FALSE),
    ('Dubois', 'Hugo', 'hdubois', '2000-01-14', 'hugo.dubois@mail.com', '$2a$10$QWERTYuiopASDFghjklZXuJ8vL3wR9mH2bN6pQ5sD1fG7hJ9kL2mC', 'Admin', 'https://cv.example.com/hdubois', 'Architecture logicielle, Docker, PostgreSQL', TRUE),
    ('Moreau', 'Emma', 'emoreau', '2002-09-09', 'emma.moreau@mail.com', '$2a$10$ZxCvBnMqWeRtYuIoPaSdF.3kL8mN2bV7cX1zA4sD6fG8hJ0kL2pQw', 'Jury', NULL, 'UML, Java, GitHub, Travail en équipe', FALSE);