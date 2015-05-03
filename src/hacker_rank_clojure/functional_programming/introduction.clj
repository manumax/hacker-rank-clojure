(ns hacker-rank-clojure.functional-programming.introduction)

;; Evaluating e^x
;; https://www.hackerrank.com/challenges/eval-ex
;;
;; The series expansion of ex is given by:
;; 1 + x + x^2/2! + x^3/3! + x^4/4! + .......
;; Evaluate e^x for given values of x, by using the above expansion for the first 10 terms.

(defn- ex-term* [x term]
  (if (= term 0)
    1
    (* (/ x term) (ex-term* x (dec term)))))

(def ex-term (memoize ex-term*))

(defn round-to-precision [precision value]
  (-> (str "%." precision "f")
      (format value)
      (read-string)))

(defn eval-ex [x terms]
  (->> (range terms) (map #(ex-term x %)) (reduce +)))

(defn all-eval-ex [values]
  (map #(->> (eval-ex % 10) (round-to-precision 4)) values))
