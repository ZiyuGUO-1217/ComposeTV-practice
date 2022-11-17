package com.composetv.data

import com.composetv.model.Burger
import javax.inject.Inject

class BurgersRepository @Inject constructor() {
    private val burgers: List<Burger> = listOf(
        Burger(
            "https://officialwebsitestorage.blob.core.chinacloudapi.cn/public/upload/attachment/2022/08/202208081013411846.png",
            "Double-Cheese",
            "435 cal",
            "¥ 20.0"
        ),
        Burger(
            "https://officialwebsitestorage.blob.core.chinacloudapi.cn/public/upload/attachment/2022/08/202208081011205699.png",
            "BigMac",
            "524 cal",
            "¥ 24.0"
        ),
        Burger(
            "https://officialwebsitestorage.blob.core.chinacloudapi.cn/public/upload/attachment/2022/08/202208081013284833.png",
            "Cheeseburger",
            "297 cal",
            "¥ 13.0"
        ),
        Burger(
            "https://officialwebsitestorage.blob.core.chinacloudapi.cn/public/upload/attachment/2022/08/202208081011488477.png",
            "Hamburger",
            "248 cal",
            "¥ 12.0"
        ),
        Burger(
            "https://officialwebsitestorage.blob.core.chinacloudapi.cn/public/upload/attachment/2022/08/202208081012023493.png",
            "Chicken Filet",
            "485 cal",
            "¥ 21.0"
        ),
        Burger(
            "https://officialwebsitestorage.blob.core.chinacloudapi.cn/public/upload/attachment/2022/08/202208081012161806.png",
            "GCB",
            "399 cal",
            "¥ 22.0"
        ),
        Burger(
            "https://officialwebsitestorage.blob.core.chinacloudapi.cn/public/upload/attachment/2022/08/202208081013175111.png",
            "Filet-O-Fish",
            "340 cal",
            "¥ 20.0"
        ),
        Burger(
            "https://officialwebsitestorage.blob.core.chinacloudapi.cn/public/upload/attachment/2022/08/202208081013011355.png",
            "Chicken Burger",
            "386 cal",
            "¥ 15.0"
        )
    )

    fun loadBurgers(): List<Burger> {
        return burgers
    }
}
