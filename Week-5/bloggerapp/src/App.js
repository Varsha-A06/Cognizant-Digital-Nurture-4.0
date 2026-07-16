import CourseDetails from "./Components/CourseDetails";
import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import "./App.css";

function App() {

  return (

    <div className="container">

      <div className="column">

        <CourseDetails />

      </div>

      <div className="column">

        <BookDetails />

      </div>

      <div className="column">

        <BlogDetails />

      </div>

    </div>

  );

}

export default App;