
package com.example.multipleapicall.modelclass;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatumResponse implements Parcelable {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    public Result getSingleMovieResult() {
        return SingleMovieResult;
    }

    public void setSingleMovieResult(Result singleMovieResult) {
        SingleMovieResult = singleMovieResult;
    }

    private Result SingleMovieResult;
    private   Boolean MOVIERESULT = false;

    public Boolean getMOVIERESULT() {
        return MOVIERESULT;
    }

    public void setMOVIERESULT(Boolean MOVIERESULT) {
        this.MOVIERESULT = MOVIERESULT;
    }

    public Boolean getPOPULARMOVIERESULT() {
        return POPULARMOVIERESULT;
    }

    public void setPOPULARMOVIERESULT(Boolean POPULARMOVIERESULT) {
        this.POPULARMOVIERESULT = POPULARMOVIERESULT;
    }

    private   Boolean POPULARMOVIERESULT = false;
    public DatumResponse(Parcel in) {
        if (in.readByte() == 0) {
            page = null;
        } else {
            page = in.readInt();
        }
        results = in.createTypedArrayList(Result.CREATOR);
        if (in.readByte() == 0) {
            totalPages = null;
        } else {
            totalPages = in.readInt();
        }
        if (in.readByte() == 0) {
            totalResults = null;
        } else {
            totalResults = in.readInt();
        }
        SingleResult = in.readParcelable(Result.class.getClassLoader());
    }

    public static final Creator<DatumResponse> CREATOR = new Creator<DatumResponse>() {
        @Override
        public DatumResponse createFromParcel(Parcel in) {
            return new DatumResponse(in);
        }

        @Override
        public DatumResponse[] newArray(int size) {
            return new DatumResponse[size];
        }
    };

    public DatumResponse() {

    }

    public Result getSingleResult() {
        return SingleResult;
    }

    public void setSingleResult(Result singleResult) {
        SingleResult = singleResult;
    }

    private Result SingleResult;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (page == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(page);
        }
        dest.writeTypedList(results);
        if (totalPages == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalPages);
        }
        if (totalResults == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalResults);
        }
        dest.writeParcelable(SingleResult, flags);
    }
}
