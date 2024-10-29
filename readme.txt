    The Rockband Song Manager is a pocket sized startup application that helps
bands label their compositions with data regarding the song title,
name of composer and year of creation.
You can create, retrieve, update and delete a song from a postgresql database,
using specific endpoints (custom URL-s).

-----------------------------------------------------------------------

    To create a song you must access this URI with 'POST' HTTP verb: "/api/songs/",
and deliver a payload containing a JSON of this format:
{
"name":"(song name)",
"composer":"(name of song composer"),
"yearOfRelease":"(year the song has been released"
}

-----------------------------------------------------------------------

    To retrieve, access this URI with a 'GET' HTTP verb:
"/api/songs/songName=?" + (name of song)
               or
"/api/songs/yearOfRelease=?" + (year of song release).


You can use either or both of them, depending on your search criteria preference.
It is also possible to concatenate them in a specific order, as in this exemple:
"/api/songs/?name=(insert name)&yearOfRelease=(insert year)"
}
-----------------------------------------------------------------------
    To update, it is enough to use a single parameter JSON, containing the new song name:
{
"name":"(new song name)"
}
and deliver it to the ""/api/songs/" endpoint, using a 'PATCH' HTTP action.

-----------------------------------------------------------------------

    To remove a song fom the database, simply use a 'DELETE' HTTP verb to this endpoint:
"/api/songs/"+(custom id number of your song)

    Use a postgresql database with the following credentials:
    used:developer
    password:developer

Now go practise! :))