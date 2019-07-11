package scb.academy.jinglebell.adapter


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import scb.academy.jinglebell.R
import scb.academy.jinglebell.activity.SongInfoActivity
import scb.academy.jinglebell.extension.setImageUrl
import scb.academy.jinglebell.vo.Song
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import scb.academy.jinglebell.activity.MainActivity


class SongAdapter(
    var context: Context,
    private var _songs: List<Song> = listOf(),
    private val onClick: (Song) -> Unit = {}
) : RecyclerView.Adapter<SongItemViewHolder>() {

    init {
        submitList(_songs)
    }

    val songs: List<Song>
        get() = _songs



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongItemViewHolder(context, parent)

    override fun onBindViewHolder(holder: SongItemViewHolder, position: Int) {
//        holder.bind(_songs[position], onClick)
        holder.bind(_songs[position], onClick)
    }

    override fun getItemCount(): Int {
        return if (songs.count() == 0) {
            0
        } else {
            songs.count() - 1
        }
    }



    fun submitList(list: List<Song>) {
        _songs = list


        notifyDataSetChanged()
    }



}

class SongItemViewHolder(var context: Context, var parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
) {

    private val ivSongArtwork: ImageView = itemView.findViewById(R.id.iv_song_artwork)
    private val tvSongName: TextView = itemView.findViewById(R.id.tv_song_name)
    private val tvSongArtist: TextView = itemView.findViewById(R.id.tv_song_artist)
    private val tvSongPrice: TextView = itemView.findViewById(R.id.tv_song_price)

    fun bind(song: Song, onClick: (Song) -> Unit = {}) {
        tvSongName.text = song.name
        tvSongArtist.text = song.artistName
        tvSongPrice.text = "${song.price} ${song.priceCurrency}"

        ivSongArtwork.setImageUrl(song.artworkUrl)

        itemView.setOnClickListener {
            Log.d("crossPage", song.toString())


//            onClick(song)
            val intentToSongDetail = Intent(context, SongInfoActivity::class.java)
            intentToSongDetail.putExtra("song", song)

            SongInfoActivity.startActivity(context, song, intentToSongDetail)

//            context.startActivity(intentToSongDetail)

//            startActivity(context, intentToSongDetail, null)
////            val inflatedView = parent
//            val inflatedView = inflate(R.layout.activity_song_info, false)
//            return SongItemViewHolder(inflatedView)

        }

    }




}
