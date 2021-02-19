package uz.rdo.projects.listoftasks.ui.fragments.alltasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.rdo.projects.listoftasks.ui.MainActivity
import uz.rdo.projects.listoftasks.data.room.entities.TaskModel
import uz.rdo.projects.listoftasks.databinding.FragmentAllBinding
import uz.rdo.projects.listoftasks.ui.adapters.TaskAdapter

@AndroidEntryPoint
class AllFragment : Fragment() {


    private var _binding: FragmentAllBinding? = null
    private val binding: FragmentAllBinding
        get() = _binding ?: throw NullPointerException("view is not available")

    private var adapter = TaskAdapter()
    private var list: ArrayList<TaskModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).changeToolBarMode(0)
        loadViews()
    }

    private fun loadViews() {
        list.add(TaskModel(1, "Task-1",desc = "desc 1",status = "Xcompleted",completedPercent = 70F,date = "december, 12", deadline = "february,17"))
        list.add(TaskModel(2, "Task-2",desc = "desc 2",status = "completed",completedPercent = 100F,date = "december, 12", deadline = "february,17"))
        list.add(TaskModel(3, "Task-3",desc = "desc 3",status = "Xcompleted",completedPercent = 10F,date = "december, 12", deadline = "february,17"))
        list.add(TaskModel(4, "Task-4",desc = "desc 4",status = "Xcompleted",completedPercent = 80F,date = "december, 12", deadline = "february,17"))
        list.add(TaskModel(5, "Task-5",desc = "desc 5",status = "completed",completedPercent = 100F,date = "december, 12", deadline = "february,17"))
        list.add(TaskModel(6, "Task-6",desc = "desc 6",status = "Xcompleted",completedPercent = 22F,date = "december, 12", deadline = "february,17"))
        list.add(TaskModel(7, "Task-7",desc = "desc 7",status = "Xcompleted",completedPercent = 60F,date = "december, 12", deadline = "february,17"))

        adapter.submitList(list)
        binding.rvAllTasks.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAllTasks.adapter = adapter
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}