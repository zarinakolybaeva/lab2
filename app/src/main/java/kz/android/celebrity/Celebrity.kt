package kz.android.celebrity



data class Celebrity(
    val name: String? =null,
    val net_worth: Long? = null,
    val gender: String? =null,
    val nationality: String? = null,
    val occupation: List<String>? = null,
    val height: Double?= null,
    val birthday: String? = null,
)
