(ns duct-talk.boundaries.comments
  (:require [duct.database.sql]
            [hugsql.core :as hugsql]))

(hugsql/def-db-fns "duct_talk/boundaries/comments.sql")

(defprotocol Comments
  (get-list [db story-id])
  (create! [db story-id text])
  (upvote! [db id]))

(extend-protocol Comments
  duct.database.sql.Boundary
  (get-list [{db :spec} story-id]
    (list-comments db {:story-id story-id}))

  (create! [{db :spec} story-id text]
    (add-comment! db {:story-id story-id
                      :comment text}))

  (upvote! [{db :spec} id]
    (upvote-comment! db {:id id})))
