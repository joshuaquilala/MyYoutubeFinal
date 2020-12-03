package com.example.myyoutubefinal.handlers


import com.example.myyoutubefinal.models.YoutubeModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class YoutubeHandler {
    var database : FirebaseDatabase
    var channelRef: DatabaseReference

    init{
        database = FirebaseDatabase.getInstance()
        channelRef = database.getReference( "channels")


    }
    fun create (channel: YoutubeModel):Boolean{
        val id = channelRef.push().key
        channel.id = id

        channelRef.child(id!!).setValue(channel)

        return true
    }
    fun update(channel: YoutubeModel): Boolean{
        channelRef.child(channel.id!!).setValue(channel)
        return true
    }
    fun delete(channel: YoutubeModel): Boolean{
        channelRef.child(channel.id!!).removeValue()
        return true
    }
}