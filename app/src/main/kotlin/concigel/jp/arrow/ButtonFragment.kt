package concigel.jp.arrow

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ButtonFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ButtonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ButtonFragment : Fragment() {

  // TODO: Rename and change types of parameters
  private var mParam1: String? = null
  private var mParam2: String? = null

  private var mListener: OnFragmentInteractionListener? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (arguments != null) {
      mParam1 = arguments.getString(ARG_PARAM1)
      mParam2 = arguments.getString(ARG_PARAM2)
    }
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    var view = inflater!!.inflate(R.layout.fragment_button, container, false)
    view.findViewById(R.id.btn_touch)?.setOnClickListener {
      Log.v(TAG, "clicked")
      val fragment = ArrowFragment()
      var fragmentTransaction: FragmentTransaction? = getFragmentManager().beginTransaction()
      fragmentTransaction!!.replace(R.id.contents, fragment)
      fragmentTransaction.addToBackStack(null)
      fragmentTransaction.commit()
    }

    // Inflate the layout for this fragment
    // return inflater!!.inflate(R.layout.fragment_button, container, false)
    return view
  }

  // TODO: Rename method, update argument and hook method into UI event
  fun onButtonPressed(uri: Uri) {
    if (mListener != null) {
      mListener!!.onFragmentInteraction(uri)
    }
  }

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is OnFragmentInteractionListener) {
      mListener = context as OnFragmentInteractionListener?
    } else {
      throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
    }
  }

  override fun onDetach() {
    super.onDetach()
    mListener = null
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   *
   *
   * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
   */
  interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    fun onFragmentInteraction(uri: Uri)
  }

  companion object {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private val ARG_PARAM1 = "param1"
    private val ARG_PARAM2 = "param2"
    private val TAG : String = "ButtonFragment"

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @param param1 Parameter 1.
     * *
     * @param param2 Parameter 2.
     * *
     * @return A new instance of fragment ButtonFragment.
     */
    // TODO: Rename and change types and number of parameters
    fun newInstance(param1: String, param2: String): ButtonFragment {
      val fragment = ButtonFragment()
      val args = Bundle()
      args.putString(ARG_PARAM1, param1)
      args.putString(ARG_PARAM2, param2)
      fragment.arguments = args
      return fragment
    }
  }
}// Required empty public constructor
