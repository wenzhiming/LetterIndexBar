package com.wzm.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wzm.indexbar.LetterIndexBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LetterIndexBar.OnSideBarListener {
    private lateinit var mLayoutManager: LinearLayoutManager

    private val letterArray: List<String> by lazy {
        var list = arrayListOf<String>()
        for (char in 'A'..'Z') {
            list.add(char.toString())
        }
        list
    }

    private val testData = mutableListOf(
        TextEntity("A", mutableListOf("阿拉伯", "阿里", "奥迪尔", "奥地利")),
        TextEntity("B", mutableListOf("北京", "北上广", "北极", "倍数", "背景")),
        TextEntity("C", mutableListOf("朝阳", "超速", "重启", "传奇")),
        TextEntity("D", mutableListOf("东北", "动静", "冬季")),
        TextEntity("E", mutableListOf("俄罗斯，二百件", "贰拾")),
        TextEntity("F", mutableListOf("风的季节", "风声", "封装", "封闭", "烽火狼烟")),
        TextEntity("G", mutableListOf("格式", "鸽子", "归仁", "盖子", "噶油")),
        TextEntity("H", mutableListOf("俄罗斯H，二百件H", "贰拾H")),
        TextEntity("I", mutableListOf("III，二百件H", "贰拾H")),
        TextEntity("J", mutableListOf("JJJ", "琉璃", "流星雨")),
        TextEntity("K", mutableListOf("里程", "琉璃", "流星雨")),
        TextEntity("L", mutableListOf("LLL", "琉璃", "流星雨")),
        TextEntity("M", mutableListOf("MMMM", "琉璃", "流星雨")),
        TextEntity("N", mutableListOf("NNNN", "琉璃", "流星雨")),
        TextEntity("O", mutableListOf("OOOO", "琉璃", "流星雨")),
        TextEntity("P", mutableListOf("PPPP", "琉璃", "流星雨")),
        TextEntity("Q", mutableListOf("QQQ", "琉璃", "流星雨")),
        TextEntity("R", mutableListOf("RRR", "琉璃", "流星雨")),
        TextEntity("S", mutableListOf("SSS", "琉璃", "流星雨")),
        TextEntity("T", mutableListOf("TTT", "琉璃", "流星雨")),
        TextEntity("U", mutableListOf("UUUU", "琉璃", "流星雨")),
        TextEntity("V", mutableListOf("VVV", "琉璃", "流星雨")),
        TextEntity("W", mutableListOf("WWW", "琉璃", "流星雨")),
        TextEntity("X", mutableListOf("XXX", "琉璃", "流星雨")),
        TextEntity("Y", mutableListOf("YYYY", "琉璃", "流星雨")),
        TextEntity("Z", mutableListOf("中心", "中间", "桌子", "琢磨"))
    )

    private val indexMap = HashMap<String, Int>()
    var data = mutableListOf<String>()

    private var mScrollState = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSideBar()
        initListData()

        //item滑动 --> 侧边栏
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, scrollState: Int) {
                super.onScrollStateChanged(recyclerView, scrollState)
                mScrollState = scrollState
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (mScrollState != -1) {
                    //第一个可见的位置
                    val layoutManager = recyclerView.layoutManager
                    //判断是当前layoutManager是否为LinearLayoutManager
                    // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                    var firstItemPosition = 0
                    if (layoutManager is LinearLayoutManager) {
                        //获取第一个可见view的位置
                        firstItemPosition = layoutManager.findFirstVisibleItemPosition()
                    }
                    side_bar.updateSideBarItem(data[firstItemPosition])
                    if (mScrollState == RecyclerView.SCROLL_STATE_IDLE) {
                        mScrollState = -1
                    }
                }
            }
        })
    }


    /**
     * set List Data
     */
    private fun initListData() {
        testData.forEachIndexed { _, textEntity ->
            indexMap[textEntity.latter] = data.size
            data.add((textEntity.latter))
            textEntity.data.forEach {
                data.add(it)
            }
        }
        mLayoutManager = LinearLayoutManager(this)
        recycler.layoutManager = mLayoutManager
        recycler.adapter = SampleAdapter(data)
    }


    /**
     * Config SideBar
     */
    private fun initSideBar() {
        side_bar.setLetters(letterArray)
        side_bar.setSideBarListener(this)
    }


    /**
     * Side Selected Callback
     * @param sideBarView SideBarView?
     * @param isTouch Boolean
     */
    override fun onSideTouchState(sideBarView: LetterIndexBar?, isTouch: Boolean) {
        if (!isTouch) {
            side_hint.visibility = View.GONE
        }
    }

    override fun onSideSelected(
        sideBarView: LetterIndexBar?,
        position: Int,
        currentY: Float,
        selectedValue: String?
    ) {
        scrollPosition(selectedValue)
        side_hint.translationY = currentY
        side_hint.text = selectedValue
        side_hint.visibility = View.VISIBLE
    }


    /**
     * scroll to Recycler position
     * @param selectedValue String
     */
    private fun scrollPosition(selectedValue: String?) {
        val index: Int? = indexMap[selectedValue]
//        Log.e("TAG", "scrollPosition==: $index")
        if (index != null) {
            mLayoutManager.scrollToPositionWithOffset(index, 0)
        }
    }
}