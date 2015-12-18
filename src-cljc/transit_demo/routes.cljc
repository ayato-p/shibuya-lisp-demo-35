(ns transit-demo.routes)

(def main
  ["/" {"" :home
        "api" {"/books" :api/find-book}}])
