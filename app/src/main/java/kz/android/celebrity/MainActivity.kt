package kz.android.celebrity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.recyclerview.widget.LinearLayoutManager
import kz.android.celebrity.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val celebrityAdapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupSearch()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCelebrities.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = celebrityAdapter
        }
    }

    private fun setupSearch() {
        binding.etSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                performSearch(v.text.toString())
                true
            } else false
        }
    }

    private fun performSearch(query: String) {
        RetrofitInstance.api.getCelebritiesByName(query).enqueue(object : Callback<List<Celebrity>> {
            override fun onResponse(call: Call<List<Celebrity>>, response: Response<List<Celebrity>>) {
                if (response.isSuccessful) {
                    response.body()?.let { celebrities ->
                        celebrityAdapter.submitList(celebrities)
                    }
                } else {
                    // Handle the error case
                }
            }

            override fun onFailure(call: Call<List<Celebrity>>, t: Throwable) {
                // Handle the failure case, such as a network error
            }
        })
    }
}
