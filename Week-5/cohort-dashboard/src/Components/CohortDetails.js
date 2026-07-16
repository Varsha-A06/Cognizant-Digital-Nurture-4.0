import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails(props) {

    return (

        <div className={styles.box}>

            <h3
                style={{
                    color:
                        props.details.currentStatus === "Ongoing"
                            ? "green"
                            : "blue"
                }}
            >
                {props.details.cohortCode}
            </h3>

            <dl>

                <dt>Started On</dt>
                <dd>{props.details.startedOn}</dd>

                <dt>Current Status</dt>
                <dd>{props.details.currentStatus}</dd>

                <dt>Coach</dt>
                <dd>{props.details.coach}</dd>

                <dt>Trainer</dt>
                <dd>{props.details.trainer}</dd>

            </dl>

        </div>

    );
}

export default CohortDetails;