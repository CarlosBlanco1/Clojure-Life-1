(ns clojure-sandbox.core-test
  (:require [clojure.test :refer :all]
            [clojure-sandbox.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest test-will-live-cell-living
  (let [set-of-living-cells #{[0 0] [0 1] [1 0] [1 1] [2 0]}
        cell1[0 0]
        cell2[-1 -1]
        cell3[1 1]]

    ;; Test case 1: A cell with 2 living neighbors should live.
    (is (= (will-live-cell-living [cell1] set-of-living-cells) true))

    ;; Test case 2: A cell with 3 living neighbors should live.
    (is (= (will-live-cell-living [cell1] set-of-living-cells) true))

    ;; Test case 3: A cell with 1 living neighbor should not live.
    (is (= (will-live-cell-living [cell2] set-of-living-cells) false))

    ;; Test case 4: A cell with 4 living neighbors should not live.
    (is (= (will-live-cell-living [cell3] set-of-living-cells) false))
  ))
