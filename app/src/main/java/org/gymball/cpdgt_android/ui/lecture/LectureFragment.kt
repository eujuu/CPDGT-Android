package org.gymball.cpdgt_android.ui.lecture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import kotlinx.android.synthetic.main.fragment_lecture.*
import kotlinx.android.synthetic.main.fragment_lecture.view.*

import org.gymball.cpdgt_android.R
import org.gymball.cpdgt_android.model.LectureListData
import org.jetbrains.anko.support.v4.startActivity

class LectureFragment : Fragment() {

    lateinit var lectureRecyclerViewAdapter: LectureRecyclerViewAdapter
    var dataList: ArrayList<LectureListData> = arrayListOf(
        LectureListData(R.drawable.lecture_detail_backgroud1,"클래스 이름", "클래스 시간대", R.drawable.lecture_comment_teacher,"뫄뫄", "_언제부터 수강 시작", "_몇일째 Gym "),
        LectureListData(R.drawable.lecture_detail_backgroud1,"클래스 이름", "클래스 시간대", R.drawable.lecture_comment_teacher,"묘묘","_언제부터 수강 시작", "_몇일째 Gym "),
        LectureListData(R.drawable.lecture_detail_backgroud1,"클래스 이름", "클래스 시간대", R.drawable.lecture_comment_teacher,"뮤뮤","_언제부터 수강 시작", "_몇일째 Gym "))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lecture, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRecyclerView()
        setView()
        setOnClickListener()
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_frag_lecture_lecture_list)
    }

    private fun setView() {
        tv_frag_lecture_lec_num.text = dataList.size.toString()
    }

    private fun setRecyclerView() {
        lectureRecyclerViewAdapter = LectureRecyclerViewAdapter(activity!!, dataList, dataList.size)
        rv_frag_lecture_lecture_list.adapter = lectureRecyclerViewAdapter
        rv_frag_lecture_lecture_list.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
        indicator_frag_lecture.attachToRecyclerView(rv_frag_lecture_lecture_list)
    }

    private fun setOnClickListener() {
        btn_frag_lecture_write_comment.setOnClickListener {
            startActivity<LectureCommentActivity>()
        }
    }
}
