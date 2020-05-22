package com.example.soptseminar1weeks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.soptseminar1weeks.book_recycler.BookAdapter
import com.example.soptseminar1weeks.book_recycler.BookData
import kotlinx.android.synthetic.main.fragment_book.*
import kotlinx.android.synthetic.main.fragment_home.*

class BookFragment : Fragment() {
    lateinit var bookAdapter: BookAdapter
    val data_books= mutableListOf<BookData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookAdapter=BookAdapter(view.context)
        rv_book.apply {
            adapter=bookAdapter
            layoutManager=GridLayoutManager(view.context, 3)
        }
        loadDatas()
    }

    private fun loadDatas(){
        data_books.apply {
            add(
                BookData(
                    title = "작은 아씨들",
                    image = "https://image.aladin.co.kr/product/21174/20/cover150/ek67263543_2.jpg" )
            )
            add(
                BookData(
                    title = "데미안",
                    image = "https://image.aladin.co.kr/product/1809/47/cover500/e893746044_2.jpg"
                ))
            add(
                BookData(
                    title = "어린왕자",
                    image = "https://image.aladin.co.kr/product/2245/67/cover150/e912435521_5.jpg"
                ))
            add(
                BookData(
                    title = "페스트",
                    image = "https://image.aladin.co.kr/product/1809/47/cover150/e893746267_2.jpg"
                ))
            add(
                BookData(
                    title = "이방인",
                    image = "https://image.aladin.co.kr/product/1933/52/cover150/e032435820_7.jpg"
                ))
            add(
                    BookData(
                        title = "1984",
                        image = "https://image.aladin.co.kr/product/2673/4/cover150/e352435848_3.jpg"
                    ))
            add(
                BookData(
                    title = "오만과 편견",
                    image = "https://image.aladin.co.kr/product/2753/61/cover150/e052435044_2.jpg"
                ))
            add(
                BookData(
                    title = "안나 카레니나",
                    image = "https://image.aladin.co.kr/product/11526/94/cover500/ek99253140_5.jpg"
                ))
            add(
                BookData(
                    title = "웃는 남자",
                    image = "https://image.aladin.co.kr/product/13913/1/cover150/ek34253004_5.jpg"
                ))
            add(
                BookData(
                    title = "젊은 베르테르의 슬픔",
                    image = "https://image.aladin.co.kr/product/2089/10/cover150/e899721378_6.jpg"
                ))
            add(
                BookData(
                    title = "변신",
                    image = "https://image.aladin.co.kr/product/5689/99/cover150/e452437349_3.jpg"
                ))
            add(
                BookData(
                    title = "사랑의 기술",
                    image = "https://image.aladin.co.kr/product/20594/1/cover150/e893101162_1.jpg"
                ))
        }
        bookAdapter.data_books=data_books
        bookAdapter.notifyDataSetChanged()
    }
}
