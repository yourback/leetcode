package com.sy.leetcode.day003

import com.sy.leetcode.day002.ListNode
import java.util.*

/**
 * @Author sy
 * @Date 2021/3/15-11:09
 * @Email 609188080@qq.com
 */

// 206. 反转链表
// https://leetcode-cn.com/problems/reverse-linked-list/
// 剑指 Offer 24. 反转链表
// https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/


// 方法一，双指针
// 时间复杂度 O(n)   空间复杂度O(1)
fun reverseList1(head: ListNode?): ListNode? {
    var pre: ListNode? = null
    var cur: ListNode? = head

    while (cur != null) {
        val next = cur.next
        cur.next = pre
        pre = cur
        cur = next
    }
    return pre
}

// 方法二，栈
// 时间复杂度O(n)  空间复杂度O(n)
fun reverseList2(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    // new stack
    val stack = LinkedList<ListNode>()
    var cur = head
    while (cur != null) {
        stack.push(cur)
        cur = cur.next
    }
    // pop one node as head
    val starterNode = stack.pop()
    cur = starterNode
    // pop one by one
    while (stack.isNotEmpty()) {
        cur!!.next = stack.pop()
        cur = cur.next
    }
    // last node`s next is null
    cur!!.next = null
    return starterNode
}