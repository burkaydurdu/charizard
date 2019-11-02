(defproject charizard/lein-template "0.1.2"
  :description "Client and server side template"
  :url "https://github.com/burkaydurdu/charizard"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :signing {:gpg-key "burkaydurdu@outlook.com"}
  :deploy-repositories [["releases" {:url "https://burkaydurdu.com/archiva/internal/releases"
                                     :signing {:gpg-key "EF97833EDB83EB7F"}}]
                        ["snapshots" "https://burkaydurdu.com/archiva/internal/snapshots"]]
  :eval-in-leiningen true)
