(ns hacker-rank-clojure.sorting.insertion-sort-test
  (:require [clojure.test :refer :all]
            [hacker-rank-clojure.sorting.insertion-sort :refer :all]))

(deftest test-first-step
  (testing "Check first step is ok"
    (is (= [2 4 6 8 8] (first (insertion-sort-steps [2 4 6 8 3]))))))

(deftest test-last-step
  (testing "Check last step is ok"
    (is (= [2 3 4 6 8] (last (insertion-sort-steps [2 4 6 8 3]))))))

(deftest test-ordered-list
  (testing "Should do nothing if given list is already ordered"
    (is (= [2 3 4 6 8] (last (insertion-sort-steps [2 4 6 8 3]))))))

(deftest test-empty-list
  (testing "Should be ok if list is empty"
    (is (= nil (last (insertion-sort-steps []))))))

(deftest test-one-element-list
  (testing "Should be ok if list has only one item"
    (is (= [1] (last (insertion-sort-steps [1]))))))