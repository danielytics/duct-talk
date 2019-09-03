(ns duct-talk.handler.stories
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response] 
            [integrant.core :as ig]
            [duct-talk.boundaries.stories :as stories]))

(defmethod ig/init-key ::index
  [_ {:keys [db]}]
  (fn [_]
    [::response/ok (stories/index db)]))

(defmethod ig/init-key ::submit
  [_ {:keys [db]}]
  (fn [{{:keys [title link]} :body-params}]
    (stories/create! db title link)
    [::response/ok "submitted"]))

(defmethod ig/init-key ::upvote
  [_ {:keys [db]}]
  (fn [{{id :id} :route-params}]
    (stories/upvote! db id)
    [::response/ok "voted"]))
