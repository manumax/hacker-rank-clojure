(ns hacker-rank-clojure.sorting.insertion-sort)

(defn parse-int [string]
  (Integer. string))

(defn read-values []
  (do
    (read-line)
    (into [] (map parse-int (clojure.string/split (read-line) #" ")))))

(defn part-one-step [v to-parse parsed]
  (lazy-seq
    (let [next-item (peek to-parse)]
      (if (or (nil? next-item) (<= next-item v))
        [(concat to-parse [v] parsed)]
        (cons (concat to-parse [(peek to-parse)] parsed)
              (part-one-step v (pop to-parse) (conj parsed next-item)))))))

(defn part-one [starting-list]
  (part-one-step (peek starting-list) (pop starting-list) '()))

(defn run-part-one
  [starting-list]
  (doall (map (comp println (partial clojure.string/join " ")) (part-one starting-list))))

(defn -main
  []
  (run-part-one [2 4 6 8 3]))