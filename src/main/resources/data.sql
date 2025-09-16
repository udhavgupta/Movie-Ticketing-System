-- src/main/resources/data.sql
INSERT INTO movie(title, language, genre, duration_mins) VALUES
('Inception','English','Sci-Fi',148),
('3 Idiots','Hindi','Comedy-Drama',170);

INSERT INTO theater(name, city) VALUES
('PVR Phoenix','Mumbai'),
('INOX Malad','Mumbai');

-- Assume generated IDs or use explicit IDs in schema.sql
-- Create a couple of shows and seats for them
