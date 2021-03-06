#### Instructions for use document
> If it helps, please give a star.🤩
[中文说明文档](README.md)

+ kotlin language development
+ Side quick index effect
+ Flexible and configurable api, customizable style

#### Style preview
<img src="https://raw.githubusercontent.com/Leo199206/SideBar/main/image/device-2021-02-19-132024.gif" width="300" heght="500" align=center />


#### import layout
```
   <?xml version="1.0" encoding="utf-8"?>
   <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       tools:context="com.wzm.sample.MainActivity">

       <androidx.recyclerview.widget.RecyclerView
           android:id="@+id/recycler"
           android:layout_width="match_parent"
           android:layout_height="match_parent" />

       <com.wzm.indexbar.LetterIndexBar
           android:id="@+id/side_bar"
           android:layout_width="50dp"
           android:layout_height="wrap_content"
           app:layout_constraintBottom_toBottomOf="parent"
           app:layout_constraintRight_toRightOf="parent"
           app:layout_constraintTop_toTopOf="parent"
           app:sideItemSpacing="10dp"
           app:sidePressedTextBgColor="@android:color/holo_orange_dark"
           app:sidePressedTextColor="@color/white"
           app:sideTextColor="@color/black"
           app:sideTextSize="14sp" />
   
   
       <TextView
           android:id="@+id/side_hint"
           android:layout_width="60dp"
           android:layout_height="44dp"
           android:layout_gravity="right"
           android:layout_marginRight="20dp"
           android:background="@drawable/bg_side_hint"
           android:backgroundTint="@android:color/holo_orange_dark"
           android:gravity="center"
           android:paddingRight="15dp"
           android:textColor="@color/white"
           android:textSize="20sp"
           android:visibility="gone"
           app:layout_constraintRight_toLeftOf="@id/side_bar"
           app:layout_constraintTop_toTopOf="parent" />
   
   </androidx.constraintlayout.widget.ConstraintLayout>
```
#### Code configuration

```

  side_bar.setLetters(letterArray)
  side_bar.setSideBarListener(object: SideBarView.OnSideBarListener{
            override fun onSideTouchState(sideBarView: SideBarView?, isTouch: Boolean) {
                //Determine whether to display the prompt according to isTouch, please refer to the example.
            }

            override fun onSideSelected(
                sideBarView: SideBarView?,
                position: Int,
                currentY: Float,
                selectedValue: String?
            ) {
             //Select callback.
             //selectedValue is the selected result.
             //According to selectedValue, go to the list to find the position you need to scroll to.
            }
        })

```

#### Attributes that

| attribute  | Description |
| --- | --- |
| sideTextColor | When not selected, the font color |
| sidePressedTextColor | When pressed to select, the font color |
| sidePressedTextBgColor | When pressed to select, the font background color |
| sideTextSize | font size | 
| sideItemSpacing | item Spacing, default is 10 |
| sideItemHeight | item Height, When not set, the default is font size height |

#### Licenses
Copyright 2022 wenzhiming

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.se Version 2.0. See the [LICENSE](https://raw.githubusercontent.com/Leo199206/SideBar/main/LICENSE) file for details.