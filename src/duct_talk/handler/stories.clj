(ns duct-talk.handler.stories
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response] 
            [integrant.core :as ig]))

(defmethod ig/init-key ::index
  [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok []]))

(defmethod ig/init-key ::submit
  [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok "submitted"]))

(defmethod ig/init-key ::upvote
  [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok "voted"]))
