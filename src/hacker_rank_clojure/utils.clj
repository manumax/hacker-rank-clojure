(ns hacker-rank-clojure.utils)

(defn parse-int [string]
  (Integer. string))

(defn read-int []
  (parse-int (read-line)))

(defn read-int-list []
  (map parse-int (clojure.string/split (read-line) #" ")))

(def pretty-print (comp println (partial clojure.string/join " ")))