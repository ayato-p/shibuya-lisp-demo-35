(ns transit-demo.util.handler
  (:require [ring.util.response :as res]))

(defn add-handler-tag [obj tag]
  (vary-meta obj assoc :handler-tag tag))

(defn same-arglists [f as-var]
  (vary-meta f assoc :arglists (:arglists (meta as-var))))

(defmacro defhandler [hname tag args & body]
  `(do
     (defn ~(add-handler-tag hname tag) ~args
       ~@body)))

(defn html-response [res]
  (res/content-type res "text/html; charset=utf-8"))

(defmacro defpagehandler [hname tag args & body]
  `(let [h# (defhandler ~hname ~tag ~args ~@body)]
     (alter-var-root h# (fn [f#] (comp html-response f#)))
     h#))

(defmacro defapihandler [hname tag args & body]
  `(let [h# (defhandler ~hname ~tag ~args ~@body)]
     h#))
