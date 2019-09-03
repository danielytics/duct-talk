CREATE TABLE comments (
  id INTEGER PRIMARY KEY,
  story_id INTEGER NOT NULL,
  comment TEXT NOT NULL,
  votes INTEGER DEFAULT 0,
  FOREIGN KEY (story_id) REFERENCES stories(id)
);

