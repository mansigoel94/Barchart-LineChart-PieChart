package com.example.mansigoel.charts

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBarChartData()

        setupLineChartData()

        setUpPieChartData()
    }

    private fun setUpPieChartData() {
        val yVals = ArrayList<PieEntry>()
        yVals.add(PieEntry(30f))
        yVals.add(PieEntry(2f))
        yVals.add(PieEntry(4f))
        yVals.add(PieEntry(22f))
        yVals.add(PieEntry(12.5f))

        val dataSet = PieDataSet(yVals, "")
        dataSet.valueTextSize=0f
        val colors = java.util.ArrayList<Int>()
        colors.add(Color.GRAY)
        colors.add(Color.BLUE)
        colors.add(Color.RED)
        colors.add(Color.GREEN)
        colors.add(Color.MAGENTA)

        dataSet.setColors(colors)
        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.centerTextRadiusPercent = 0f
        pieChart.isDrawHoleEnabled = false
        pieChart.legend.isEnabled = false
        pieChart.description.isEnabled = false
    }

    private fun setupLineChartData() {
        val yVals = ArrayList<Entry>()
        yVals.add(Entry(0f, 30f, "0"))
        yVals.add(Entry(1f, 2f, "1"))
        yVals.add(Entry(2f, 4f, "2"))
        yVals.add(Entry(3f, 6f, "3"))
        yVals.add(Entry(4f, 8f, "4"))
        yVals.add(Entry(5f, 10f, "5"))
        yVals.add(Entry(6f, 22f, "6"))
        yVals.add(Entry(7f, 12.5f, "7"))
        yVals.add(Entry(8f, 22f, "8"))
        yVals.add(Entry(9f, 32f, "9"))
        yVals.add(Entry(10f, 54f, "10"))
        yVals.add(Entry(11f, 28f, "11"))

        val set1: LineDataSet
        set1 = LineDataSet(yVals, "DataSet 1")

        // set1.fillAlpha = 110
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        // set1.enableDashedLine(5f, 5f, 0f);
        // set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.color = Color.BLUE
        set1.setCircleColor(Color.BLUE)
        set1.lineWidth = 1f
        set1.circleRadius = 3f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 0f
        set1.setDrawFilled(false)

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1)
        val data = LineData(dataSets)

        // set data
        lineChart.setData(data)
        lineChart.description.isEnabled = false
        lineChart.legend.isEnabled = false
        lineChart.setPinchZoom(true)
        lineChart.xAxis.enableGridDashedLine(5f, 5f, 0f)
        lineChart.axisRight.enableGridDashedLine(5f, 5f, 0f)
        lineChart.axisLeft.enableGridDashedLine(5f, 5f, 0f)
        //lineChart.setDrawGridBackground()
        lineChart.xAxis.labelCount = 11
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
    }

    private fun setupBarChartData() {
        // create BarEntry for Bar Group
        val bargroup = ArrayList<BarEntry>()
        bargroup.add(BarEntry(0f, 30f, "0"))
        bargroup.add(BarEntry(1f, 2f, "1"))
        bargroup.add(BarEntry(2f, 4f, "2"))
        bargroup.add(BarEntry(3f, 6f, "3"))
        bargroup.add(BarEntry(4f, 8f, "4"))
        bargroup.add(BarEntry(5f, 10f, "5"))
        bargroup.add(BarEntry(6f, 22f, "6"))
        bargroup.add(BarEntry(7f, 12.5f, "7"))
        bargroup.add(BarEntry(8f, 22f, "8"))
        bargroup.add(BarEntry(9f, 32f, "9"))
        bargroup.add(BarEntry(10f, 54f, "10"))
        bargroup.add(BarEntry(11f, 28f, "11"))

        // creating dataset for Bar Group
        val barDataSet = BarDataSet(bargroup, "")

        barDataSet.color = ContextCompat.getColor(this, R.color.amber)

        val data = BarData(barDataSet)
        barChart.setData(data)
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.xAxis.labelCount = 11
        barChart.xAxis.enableGridDashedLine(5f, 5f, 0f)
        barChart.axisRight.enableGridDashedLine(5f, 5f, 0f)
        barChart.axisLeft.enableGridDashedLine(5f, 5f, 0f)
        barChart.description.isEnabled = false
        barChart.animateY(1000)
        barChart.legend.isEnabled = false
        barChart.setPinchZoom(true)
        barChart.data.setDrawValues(false)
    }
}
