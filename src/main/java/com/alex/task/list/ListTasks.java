package com.alex.task.list;

import com.alex.datastructure.LinkedList;

public class ListTasks {
    public static <T> LinkedList.Node<T> findMthFromTail(LinkedList<T> list, int m) {
        if (m < 0) {
            throw new IllegalArgumentException("Invalid index " + m);
        }

        LinkedList.Node<T> mBehind = null;

        int currentIndex = 0;
        LinkedList.Node<T> currentNode = list.getHead();
        while (currentNode != null) {
            if (currentIndex - m >= 0) {
                mBehind = mBehind == null ? list.getHead() : mBehind.getNext();
            }

            currentIndex++;
            currentNode = currentNode.getNext();
        }

        return mBehind;
    }

    public static <T> boolean containsCycles(LinkedList.Node<T> node) {
        //TODO or we can return getCycleStart != null

        LinkedList.Node<T> slow = node;
        LinkedList.Node<T> fast = node;

        while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static <T> LinkedList.Node<T> getCycleStart(LinkedList.Node<T> node) {
        LinkedList.Node<T> slow = node;
        LinkedList.Node<T> fast = node;

        while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (fast == slow) {
                slow = node;

                while (slow != fast) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }

                return slow;
            }
        }

        return null;
    }

    public static <T> void fastRemoveFromMiddle(LinkedList.Node<T> node) {
        if (node.getNext() == null) {
            throw new IllegalArgumentException("Node can't be tail");
        }

        LinkedList.Node<T> next = node.getNext();
        node.setData(next.getData());
        node.setNext(next.getNext());
        next.setNext(null);
        next.setData(null);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> LinkedList<T> merge(LinkedList<T> left, LinkedList<T> right) {
        LinkedList.Node<T> resultHead = new LinkedList.Node<>(null);//dummy
        LinkedList.Node<T> resultTail = resultHead;

        LinkedList.Node<T> leftCurr = left.getHead();
        LinkedList.Node<T> rightCurr = right.getHead();

        while (leftCurr != null && rightCurr != null) {
            int compare = leftCurr.getData().compareTo(rightCurr.getData());
            if (compare < 0) {
                resultTail.setNext(leftCurr);
                resultTail = leftCurr;
                leftCurr = leftCurr.getNext();
            } else if (compare > 0) {
                resultTail.setNext(rightCurr);
                resultTail = rightCurr;
                rightCurr = rightCurr.getNext();
            } else {
                resultTail.setNext(leftCurr);
                resultTail = leftCurr;
                leftCurr = leftCurr.getNext();

                resultTail.setNext(rightCurr);
                resultTail = rightCurr;
                rightCurr = rightCurr.getNext();
            }
        }

        if (leftCurr != null) {
            resultTail.setNext(leftCurr);
        }

        if (rightCurr != null) {
            resultTail.setNext(rightCurr);
        }

        return new LinkedList<>(resultHead.getNext());
    }

    public static <T> T findMedianFromSorted1(LinkedList<T> list) {
        LinkedList.Node<T> curr = list.getHead();
        LinkedList.Node<T> result = null;
        int i = 1;

        while (curr != null) {
            if (i % 2 == 1) {
                result =  result == null ? list.getHead() : result.getNext();
            }

            i++;
            curr = curr.getNext();
        }

        return result == null ? list.getHead().getData() : result.getData();
    }

    public static <T> T findMedianFromSorted2(LinkedList<T> list) {
        LinkedList.Node<T> slow = list.getHead();
        LinkedList.Node<T> fast = list.getHead().getNext();

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow.getData();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> T findMedianFromSortedCircular(LinkedList.Node<T> input) {
        int i = 0;
        LinkedList.Node<T> head = input; //head is the smallest value
        LinkedList.Node<T> curr = input.getNext();

        do {
            i++;

            if (curr.getData().compareTo(head.getData()) < 0) {
                head = curr;
            }

            curr = curr.getNext();
        } while ((curr != input.getNext()));

        int median = i / 2;
        if (i % 2 == 0) {
            median--;
        }
        i = 0;
        LinkedList.Node<T> result = head;
        while (i < median) {
            result = result.getNext();
            i++;
        }

        return result.getData();
    }

    public static <T> LinkedList.Node<T> findOverlappingNoCycle(LinkedList<T> l1, LinkedList<T> l2) {
        int l1Size = l1.getSize();
        int l2Size = l2.getSize();

        LinkedList.Node<T> l1curr = l1.getHead();
        LinkedList.Node<T> l2curr = l2.getHead();

        int diff = Math.abs(l1Size - l2Size);
        if (l1Size > l2Size) {
            while (diff > 0) {
                l1curr = l1curr.getNext();
                diff--;
            }
        } else if (l1Size < l2Size) {
            while (diff > 0) {
                l2curr = l2curr.getNext();
                diff--;
            }
        }

        while (l1curr != null && l2curr != null && l1curr != l2curr) {
            l1curr = l1curr.getNext();
            l2curr = l2curr.getNext();
        }

        return l1curr;
    }

    public static <T> LinkedList.Node<T> findOverlapping(LinkedList<T> l1, LinkedList<T> l2) {
        LinkedList.Node<T> l1CycleStart = getCycleStart(l1.getHead());
        LinkedList.Node<T> l2CycleStart = getCycleStart(l2.getHead());

        if (l1CycleStart == null && l2CycleStart == null) {
            return findOverlappingNoCycle(l1, l2);
        }

        if (l1CycleStart != null && l2CycleStart != null) {
            //check that they are the same cycles
            LinkedList.Node<T> curr = l1CycleStart;
            do {
                //node from second cycle is in first cycle
                if (curr == l2CycleStart) {
                    return curr;
                }

                curr = curr.getNext();
            } while (curr != l1CycleStart);
        }

        return null;
    }

    public static <T> LinkedList.Node<T> evenOddMerge(LinkedList.Node<T> node) {
        LinkedList.Node<T> evenCurr = node;
        LinkedList.Node<T> evenPrev = null;

        LinkedList.Node<T> odd = node.getNext();
        LinkedList.Node<T> oddCurr = odd;

        while (evenCurr != null && oddCurr != null) {
            evenCurr.setNext(oddCurr.getNext());
            evenPrev = evenCurr;
            evenCurr = evenCurr.getNext();

            if (evenCurr != null) {
                oddCurr.setNext(evenCurr.getNext());
                oddCurr = oddCurr.getNext();
            }
        }

        if (evenCurr != null) {
            evenPrev = evenCurr;
        }

        evenPrev.setNext(odd);

        return node;
    }

    public static <T> LinkedList<T> reverse(LinkedList<T> original) {
        //single element list
        if (original.getHead() == original.getTail()) {
            return original;
        }

        LinkedList.Node<T> prev = null;
        LinkedList.Node<T> curr = original.getHead();

        while (curr != null) {
            LinkedList.Node<T> next = curr.getNext();
            curr.setNext(prev);

            prev = curr;
            curr = next;
        }

        return new LinkedList<>(original.getTail());
    }

    public static <T> LinkedList<T> reverseK(LinkedList<T> list, int k) {
        LinkedList.Node<T> resultHead = new LinkedList.Node<>(null);
        LinkedList.Node<T> resultTail = resultHead;

        LinkedList.Node<T> curr = list.getHead();
        LinkedList.Node<T> subListTailPreceding = curr;
        LinkedList.Node<T> subListTail = curr;

        while (curr != null) {
            int tmp = k;
            while (tmp > 0) {
                subListTailPreceding = subListTail;
                subListTail = subListTail.getNext();

                tmp--;

                if (subListTail == null) {
                    break;
                }
            }

            if (tmp > 0) {
                resultTail.setNext(curr);
                break;
            }

            subListTailPreceding.setNext(null);

            LinkedList<T> reversed = reverse(new LinkedList<>(curr));
            resultTail.setNext(reversed.getHead());
            resultTail = reversed.getTail();

            curr = subListTail;
        }

        return new LinkedList<>(resultHead.getNext());
    }

    public static <T> boolean isPalindrome(LinkedList<T> list) {
        LinkedList.Node<T> median = list.getHead();
        LinkedList.Node<T> fast = list.getHead();

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            median = median.getNext();
        }

        LinkedList<T> reversed = reverse(new LinkedList<>(median));

        LinkedList.Node<T> reversedCurr = reversed.getHead();
        LinkedList.Node<T> originalCurr = list.getHead();

        while (reversedCurr != null) {
            if (!reversedCurr.getData().equals(originalCurr.getData())) {
                return false;
            }

            reversedCurr = reversedCurr.getNext();
            originalCurr = originalCurr.getNext();
        }

        return true;
    }

    public static <T> LinkedList<T> cyclicShift(LinkedList<T> list, int k) {
        if (k == 0) {
            return list;
        }

        //k + 1 1 will be new tail
        k = k + 1;

        LinkedList.Node<T> currentHead = list.getHead();
        LinkedList.Node<T> newTail = null;
        int currentIndex = 0;
        LinkedList.Node<T> currentNode = null;
        do {
            currentNode = (currentNode == null) ? currentHead : currentNode.getNext();
            currentIndex++;

            if (currentIndex - k >= 0) {
                newTail = newTail == null ? list.getHead() : newTail.getNext();
            }

        } while (currentNode.getNext() != null);

        //k - the same as list size
        if (currentIndex == k - 1) {
            return list;
        }

        if (newTail == null) {
            throw new IllegalArgumentException("List's length is less than K");
        }

        LinkedList.Node<T> newHead = newTail.getNext();
        newTail.setNext(null);

        //point current tail to the current head
        currentNode.setNext(currentHead);
        return new LinkedList<>(newHead);
    }

    public static LinkedList<Integer> listPivoting(LinkedList<Integer> list, int x) {
        LinkedList.Node<Integer> leftHead = null;
        LinkedList.Node<Integer> left = null;

        LinkedList.Node<Integer> pivotHead = null;
        LinkedList.Node<Integer> pivot = null;

        LinkedList.Node<Integer> rightHead = null;
        LinkedList.Node<Integer> right = null;

        LinkedList.Node<Integer> current = list.getHead();
        while (current != null) {
            if (current.getData() < x) {
                if (leftHead == null) {
                    leftHead = current;
                } else {
                    left.setNext(current);
                }
                left = current;
            } else if (current.getData() > x) {
                if (rightHead == null) {
                    rightHead = current;
                } else {
                    right.setNext(current);
                }
                right = current;
            } else {
                if (pivotHead == null) {
                    pivotHead = current;
                } else {
                    pivot.setNext(current);
                }
                pivot = current;
            }

            LinkedList.Node<Integer> tmp = current.getNext();
            current.setNext(null);
            current = tmp;
        }

        MergeResult<Integer> merge = merge(leftHead, left, pivotHead, pivot);
        if (merge == null) {
            return new LinkedList<>(rightHead);
        }

        merge = merge(merge.head, merge.tail, rightHead, right);

        return new LinkedList<>(merge.head);
    }

    public static int addTwoNumbersReversed(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int result = 0;
        int carryOver = 0;
        int pow = 0;

        LinkedList.Node<Integer> left = l1.getHead();
        LinkedList.Node<Integer> right = l2.getHead();

        while (left != null && right != null) {
            int tmp = left.getData() + right.getData() + carryOver;
            carryOver = tmp / 10;
            result += (tmp % 10) * Math.pow(10, pow);

            pow++;
            left = left.getNext();
            right = right.getNext();
        }

        LinkedList.Node<Integer> tail = left != null ? left : right;
        while (tail != null) {
            int tmp = tail.getData() + carryOver;
            carryOver = tmp / 10;
            result += (tmp % 10) * Math.pow(10, pow);

            pow++;
            tail = tail.getNext();
        }

        if (carryOver > 0) {
            result += carryOver * Math.pow(10, pow);
        }

        return result;
    }

    private static <T> MergeResult<T> merge(
            LinkedList.Node<T> leftHead,
            LinkedList.Node<T> leftTail,
            LinkedList.Node<T> rightHead,
            LinkedList.Node<T> rightTail) {
        if (leftHead == null && rightHead == null) {
            return null;
        }

        if (leftHead == null) {
            return new MergeResult<>(rightHead, rightTail);
        }

        if (rightHead == null) {
            return new MergeResult<>(leftHead, leftTail);
        }

        leftTail.setNext(rightHead);
        return new MergeResult<>(leftHead, rightTail);
    }

    private static class MergeResult<T> {
        LinkedList.Node<T> head;
        LinkedList.Node<T> tail;

        public MergeResult(LinkedList.Node<T> head, LinkedList.Node<T> tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
