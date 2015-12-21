(ns transit-demo.handler.api
  (:require [ring.util.response :as res]
            [transit-demo.db :as db]
            [transit-demo.util.handler :refer [defhandler]]))

(defhandler search-book :api/search-book [req]
  (res/response (db/find-book)))
