package cn.xzxy.lewy.oop

import java.awt.event.ActionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.JButton
import javax.swing.JFrame

/**
 * 对象表达式 ==> 主要解决java中匿名内部类的一些问题
 *
 * 关于匿名内部类：
 * 1. 一定是实现了某个接口或者实现了某个父类；
 * 2. Java运行时会将该匿名内部类当作它所实现的接口或是继承的父类来看待；
 * 3. 匿名内部类没有名称；
 *
 * 对象表达式的格式：
 * object [: 若干个父类型，中间用逗号分隔]
 */
fun main(args: Array<String>) {
    val jFrame: JFrame = JFrame("oo jFrame")
    val jButton: JButton = JButton("oo jButton")

    // 匿名内部类在时间监听器中用的比较多，object可以替换匿名内部类
    jFrame.addWindowListener(object : WindowListener {
        override fun windowDeiconified(e: WindowEvent?) {
        }

        override fun windowClosing(e: WindowEvent?) {
            println("windowClosing")
        }

        override fun windowClosed(e: WindowEvent?) {
        }

        override fun windowActivated(e: WindowEvent?) {
            println("windowActivated")
        }

        override fun windowDeactivated(e: WindowEvent?) {
        }

        override fun windowOpened(e: WindowEvent?) {
            println("windowOpened")
        }

        override fun windowIconified(e: WindowEvent?) {
        }
    })

    // lambda 表达式
    // 如果对象是java函数式接口的一个实例（即只拥有一个抽象方法的接口），
    // 那么可以通过lambda表达式来调用，其中lambda前面加上接口的类型。
    //jButton.addActionListener(object :ActionListener{
    //    override fun actionPerformed(e: ActionEvent?) {
    //        println("actionPerformed")
    //    }
    //})
    // 上面转lambda为:
    jButton.addActionListener { println("ActionListener") } // 其中类型被省略了

    // 但是lambda表达式只适用于对象表达式中只有一个回调函数的情况，
    // 当回调函数有多个时，如上例有7个回调函数，此时lambda表达式就不适用

    val listener: ActionListener = ActionListener { println("ActionListener") }
    println(listener.javaClass)
    // 转lambda 为：
    println(listener::class)

    println(listener.javaClass.superclass)
    // 转lambda 为：
    println(listener::class.java.superclass)

    jFrame.add(jButton)
    jFrame.pack()
    jFrame.isVisible = true
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}