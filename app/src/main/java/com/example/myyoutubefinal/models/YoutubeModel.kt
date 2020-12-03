package com.example.myyoutubefinal.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class YoutubeModel(var id:String? = "", var channel: String? = "", var link:String? = "", var rank:Int = 0, var desc:String? = ""): Comparable<YoutubeModel>{
    override fun toString(): String {
        return "$channel , Link: $link, Rank: $rank , Description: $desc"
    }

    override fun compareTo(other: YoutubeModel): Int {
        return if(this.rank != other.rank){
            this.rank - other.rank
        }else{
            0
        }
    }

}