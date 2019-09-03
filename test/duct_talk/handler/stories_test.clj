(ns duct-talk.handler.stories-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [ring.mock.request :as mock]
            [duct-talk.handler.stories :as stories]))

(deftest smoke-test
  (testing "example page exists"
    (let [handler  (ig/init-key :duct-talk.handler.stories/index {})
          response (handler (mock/request :get "/example"))]
      (is (= :ataraxy.response/ok (first response)) "response ok"))))
