(ns hacker-rank-clojure.sorting.insertion-sort
  (:require [hacker-rank-clojure.utils :as utils]))

(defn insertion-sort-steps
  ([starting-list]
   (when (seq starting-list)
     (insertion-sort-steps (peek starting-list) (pop starting-list) '())))
  ([v to-parse parsed]
   (lazy-seq
     (let [next-item (peek to-parse)]
       (if (or (nil? next-item) (<= next-item v))
         [(concat to-parse [v] parsed)]
         (cons (concat to-parse [(peek to-parse)] parsed)
               (insertion-sort-steps v (pop to-parse) (conj parsed next-item))))))))
