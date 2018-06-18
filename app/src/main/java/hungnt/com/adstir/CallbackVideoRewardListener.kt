package hungnt.com.adstir

/**
 * Created by HungNT on 6/15/18.
 */
interface CallbackVideoRewardListener {

    fun onLoad()

    fun onFailed()

    fun onStart()

    fun onStartFailed()

    fun onFinished()

    fun onReward()

    fun onRewardCanceled()

    fun onClose()

}
