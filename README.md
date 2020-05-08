# [Read Me]

### - margin과 ConstraintLayout의 제약의 선후조건

margin값이 적용 된 후의 컴포넌트의 위치를 기준으로 다른 컴포넌트가 위치제약을 걸게 된다.


### - Guideline #

<androidx.constraintlayout.widget.Guideline android:id="@+id/guideline" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintGuide_percent="0.5" android:orientation="vertical" />

layout_constraintGuide_percent
세로 가이드라인 선을 사용하기 위해서 
orientation을 vertical로 지정한다. layout_constraintGuide_percent에 비율을 입력하여 최상위부모의 화면크기를 기준으로 퍼센트 비율로 가이드라인을 설정할 수 있고, 
layout_constraintGuide_begin, layout_constraintGuide_end
을 통하여 가이드라인의 시작위치와 끝나는 위치를 dp값으로 지정할 수도 있다.
