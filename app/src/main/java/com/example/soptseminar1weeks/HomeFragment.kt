package com.example.soptseminar1weeks

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soptseminar1weeks.insta_recycler.InstaAdapter
import com.example.soptseminar1weeks.insta_recycler.InstaData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var instaAdapter: InstaAdapter
    val datas= mutableListOf<InstaData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter=InstaAdapter(view.context)
        rv_home.adapter=instaAdapter // 이 리사이클러뷰의 어답터는 InstaAdapter
        rv_home.addItemDecoration(MyDivideLine(100, Color.CYAN)) // rv의 구분선
        loadDatas()
    }

    private fun loadDatas(){
        datas.apply {
            add(
                InstaData(
                    userName = "cat1",
                    img_profile = "https://cdn.pixabay.com/photo/2017/02/15/12/12/cat-2068462__480.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2018/03/26/02/05/cat-3261420__480.jpg"
                ))
            add(
                InstaData(
                    userName = "cat2",
                    img_profile = "https://cdn.pixabay.com/photo/2014/04/13/20/49/cat-323262__480.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2017/07/25/01/22/cat-2536662__480.jpg"
                ))
            add(
                InstaData(
                    userName = "cat3",
                    img_profile = "https://cdn.pixabay.com/photo/2016/01/19/17/41/friends-1149841__480.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2017/11/14/13/06/kitty-2948404__480.jpg"
                ))
            add(
                InstaData(
                    userName = "cat4",
                    img_profile = "https://cdn.pixabay.com/photo/2016/01/20/13/05/cat-1151519__480.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2016/09/07/16/19/bremen-town-musicians-1651945__480.jpg"
                ))
        }
        instaAdapter.datas=datas
        instaAdapter.notifyDataSetChanged()
    }
}

class MyDivideLine(
    private val dividerHeight: Int,
    private val dividerColor: Int = Color.TRANSPARENT
) : RecyclerView.ItemDecoration(){
    private val paint = Paint()

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        myDivider(c, parent, color = dividerColor)
    }

    private fun myDivider(c: Canvas, parent: RecyclerView, color:Int){
        paint.color=color

        for(i in 0 until parent.childCount){
            val child = parent.getChildAt(i)
            val param = child.layoutParams as RecyclerView.LayoutParams

            val dividerTop = child.bottom + param.bottomMargin
            val dividerBottom = dividerTop + dividerHeight

            c.drawRect(
                child.left.toFloat(),
                dividerTop.toFloat(),
                child.right.toFloat(),
                dividerBottom.toFloat(),
                paint
            )
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = dividerHeight
    }
}
