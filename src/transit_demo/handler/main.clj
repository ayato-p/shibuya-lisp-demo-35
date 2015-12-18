(ns transit-demo.handler.main
  (:require [ring.util.response :as res]
            [transit-demo.util.handler :refer [defpagehandler]]
            [transit-demo.view.main :as view]))

(defpagehandler home :home [req]
  (-> (view/main)
      res/response))
