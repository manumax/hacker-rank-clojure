(ns hacker-rank-clojure.sorting.insertion-sort)

(defn part-one [starting-list]
  (loop [v        (peek starting-list)
         to-parse (pop starting-list)
         parsed   '()]
    (println (concat to-parse (vector v) parsed))
    (let [next-item (peek to-parse)]
      (if (or (nil? next-item) (<= next-item v))
        (concat to-parse (vector v) parsed)
        (recur v (pop to-parse) (conj parsed next-item))))))
