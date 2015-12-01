(defproject transit-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src" "src-cljc"]
  :plugins [[lein-cljsbuild "1.1.1"]]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [org.immutant/web "2.1.1"]
                 [ring/ring-defaults "0.1.5"]
                 [ring-transit "0.1.4"]
                 [bidi "1.21.1"]
                 [hiccup "1.0.5"]

                 [org.clojure/clojurescript "1.7.170"]
                 [com.cognitect/transit-cljs "0.8.232"]
                 [cljs-ajax "0.5.1"]]
  :cljsbuild
  {:builds [{:source-paths ["src-cljc" "src-cljs"]
             :compiler {:output-to "resources/public/js/main.js"
                        :optimizations :whitespace
                        :pretty-print true}}]})
