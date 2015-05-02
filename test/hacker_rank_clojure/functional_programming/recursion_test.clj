(ns hacker-rank-clojure.functional-programming.recursion-test
  (:require [clojure.test :refer :all]
            [hacker-rank-clojure.functional-programming.recursion :refer :all]))

;; Computing the GCD

(deftest test-first-sample-return-value
  (testing "Verify first given sample works properly"
    (is (= 1 (GCD 1 5)))))

(deftest test-second-sample-return-value
  (testing "Verify second given sample works properly"
    (is (= 10 (GCD 10 100)))))

(deftest test-third-sample-return-value
  (testing "Verify third given sample works properly"
    (is (= 1 (GCD 22 131)))))

(deftest test-first-example-from-video
  (testing "Verify first video ample works properly"
    (is (= 5 (GCD 10 45)))))

(deftest test-second-example-from-video
  (testing "Verify second video sample works properly"
    (is (= 3 (GCD 1701 3768)))))

;; Fibonacci Numbers

(deftest test-fibonacci-of-1
  (testing "For this exercise, Fibonacci of 1 is 0 by definition"
    (is (= 0 (fibonacci 1)))))

(deftest test-fibonacci-of-2
  (testing "For this exercise, Fibonacci of 2 is 1 by definition"
    (is (= 1 (fibonacci 2)))))

(deftest test-fibonacci-first-sample-return-value
  (testing "Verify first given sample works properly"
    (is (= 1 (fibonacci 3)))))

(deftest test-fibonacci-second-sample-return-value
  (testing "Verify first given sample works properly"
    (is (= 3 (fibonacci 5)))))
