(ns hacker-rank-clojure.functional-programming.recursion)

;; Computing the GCD
;; (https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd)

(defn GCD [x y]
  ;; We want to guarantee that x is lesser or equal to y
  (when (< y x)
    (GCD y x))
  ;; Here x is lesser or equal to y
  (let [ny x
        nx (rem y x)]
    (if (= 0 nx)
      x
      (recur nx ny))))

;; Fibonacci Numbers
;; (https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers)

(defn- fibonacci-recur [n]
  (cond
    (= n 1) 0
    (= n 2) 1
    :otherwise (+ (fibonacci-recur (- n 1))
                  (fibonacci-recur (- n 2)))))

(def fibonacci (memoize fibonacci-recur))