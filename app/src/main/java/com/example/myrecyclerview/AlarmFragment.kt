package com.example.myrecyclerview

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myrecyclerview.databinding.FragmentAlarmBinding
import java.util.Calendar

class AlarmFragment : Fragment() {
    private lateinit var binding: FragmentAlarmBinding
    private lateinit var alarmManager: AlarmManager
    private lateinit var oneTimeAlarmIntent: PendingIntent
    private var intent: Intent? = null
    private val ALARM_TYPE = "ALARM_TYPE"
    private val ALARM_TYPE_ONE_TIME = "ALARM_TYPE_ONE_TIME"
    private val ALARM_DESCRIPTION = "ALARM_DESCRIPTION"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alarmManager =
            requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager

        intent = Intent(requireContext(), Myreceiver::class.java)
        oneTimeAlarmIntent = PendingIntent.getBroadcast(
            requireContext(),
            0,
            intent!!,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Setup one-time alarm
        setupOneTimeAlarm()

        binding.mulai.setOnClickListener {
            intent!!.putExtra(ALARM_TYPE, ALARM_TYPE_ONE_TIME)
            intent!!.putExtra(ALARM_DESCRIPTION, "BANGUN COOOOO")

            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (5 * 1000),
                oneTimeAlarmIntent
            )
            Toast.makeText(requireContext(), "set Alarm ", Toast.LENGTH_SHORT).show()
        }

        binding.berhenti.setOnClickListener {
            alarmManager.cancel(oneTimeAlarmIntent)
            Toast.makeText(requireContext(), "Alarm berhenti", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupOneTimeAlarm() {
        intent = Intent(requireContext(), Myreceiver::class.java)
        intent!!.putExtra(ALARM_TYPE, ALARM_TYPE_ONE_TIME)
        intent!!.putExtra(ALARM_DESCRIPTION, "BANGUN COOOOO")

        oneTimeAlarmIntent = PendingIntent.getBroadcast(
            requireContext(),
            0,
            intent!!,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.SECOND, 10) // 10 seconds from now

        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            oneTimeAlarmIntent
        )
    }
}
