(ns duct-talk.handler.comments
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response] 
            [integrant.core :as ig]
            [duct-talk.boundaries.comments :as comments]))

(defmethod ig/init-key ::list
  [_ {:keys [db]}]
  (fn [{{id :story-id} :route-params}]
    [::response/ok (comments/get-list db id)]))

(defmethod ig/init-key ::submit
  [_ {:keys [db]}]
  (fn [{{text :comment} :body-params
        {id :story-id} :route-params}]
    (comments/create! db id text)
    [::response/ok "submitted"]))

(defmethod ig/init-key ::upvote
  [_ {:keys [db]}]
  (fn [{{id :story-id} :route-params}]
    (comments/upvote! db id)
    [::response/ok "voted"]))

