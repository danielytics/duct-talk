(ns duct-talk.boundaries.stories
  (:require [duct.database.sql]
            [hugsql.core :as hugsql]))

(hugsql/def-db-fns "duct_talk/boundaries/stories.sql")

(defprotocol Stories
  (index [db])
  (create! [db title url])
  (upvote! [db id]))

(extend-protocol Stories
  duct.database.sql.Boundary
  (index [{db :spec}]
    (list-stories db))

  (create! [{db :spec} title link]
    (create-story! db {:title title
                       :link link}))

  (upvote! [{db :spec} id]
    (upvote-story! db {:id id})))
