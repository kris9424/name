import android.os.Bundle
import com.example.finaltask.R
import com.example.finaltask.view.AddFragment
import com.example.finaltask.view.ViewFragment

private val postViewModel: PostViewModel by viewModels()

private lateinit var addFragment: AddFragment
private lateinit var viewFragment: ViewFragment

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    addFragment = AddFragment.newInstance()
    viewFragment = ViewFragment.newInstance()
    postViewModel.currentFragment.observe(this) {
        when(it){
            StateFragments.View -> postViewModel.goToView(supportFragmentManager, viewFragment)
            StateFragments.Add -> postViewModel.goToAdd(supportFragmentManager, addFragment)
        }
    }
}
}