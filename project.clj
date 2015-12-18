(defproject transit-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repl-options {:init-ns transit-demo.repl}
  :source-paths ["src" "src-cljc"]
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-environ "1.0.1"]]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [ring/ring-core "1.4.0"]
                 [org.immutant/web "2.1.1"]
                 [ring/ring-defaults "0.1.5"]
                 [bidi "1.21.1"]
                 [hiccup "1.0.5"]
                 [com.gfredericks/cljs-numbers "0.1.2"]
                 [com.stuartsierra/component "0.3.1"]
                 ;; 明示的に Transit のバージョンを指定したかっただけで本当は依存関係に Transit 含まれている
                 [ring-transit "0.1.4"]
                 [cljs-ajax "0.5.1" :exclusions [com.cognitect/transit-clj com.cognitect/transit-cljs]]
                 [com.cognitect/transit-clj "0.8.285"]
                 [com.cognitect/transit-cljs "0.8.232"]

                 ;; Misc
                 [bultitude "0.2.8"]
                 [environ "1.0.1"]
                 [rkworks/baum "0.3.0"]]

  :cljsbuild
  {:builds [{:source-paths ["src-cljc" "src-cljs"]
             :compiler {:output-to "resources/public/js/main.js"
                        :optimizations :whitespace
                        :pretty-print true}}]}

  :profiles
  {:dev {:resource-paths ["dev-resources"]
         :source-paths ["env/dev/clj"]
         :dependencies [[ring/ring-devel "1.4.0"]
                        [figwheel-sidecar "0.5.0-2"]]
         :env {:dev true}}})
